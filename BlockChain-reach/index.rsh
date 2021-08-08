'reach 0.1';


export const main = Reach.App(() => {
  // { deployMode: 'constructor' },
  const common ={
    inform_DDL:Fun([UInt],Null)
  }

  const Fundraiser = Participant('Fundraiser', {
    ...common,
    getParams: Fun([], Object({
      object_amount: UInt,
      duration: UInt,
    }))
  });

  const Receiver = Participant('Receiver', {
    ...common,
    showBalance: Fun([], Null),
    showAddress: Fun([], Address),
    showDifficulty: Fun([], Bytes(64))
  });

  const Donors = ParticipantClass('Donors', {
    ...common,
    getPayment: Fun([], UInt),
    getAmount: Fun([UInt, UInt, UInt], Maybe(UInt))
  })

  // setOptions({ deployMode: 'constructor'});
  deploy();


  // (Fundraiser, Receiver, Donors) => {

  Receiver.only(() => {

    const difficulty = declassify(interact.showDifficulty())
    const receiverAddr = declassify(interact.showAddress())
  })

  Receiver.publish(receiverAddr, difficulty)
  // Receiver.set(receiverAddr);
  commit()

  Fundraiser.only(() => {
    const {
      object_amount, duration }
      = declassify(interact.getParams());
  });

  Fundraiser.publish(
    object_amount, duration)
  // .pay(payment);

  
  commit();


  Donors.publish()

  assert(balance()==0)

  const [timeRemaining, keepGoing] = makeDeadline(duration);


  const [publisher, isFirstDonate, currentAmount] =
    parallelReduce([Fundraiser, true, 0])
      .invariant(balance() == currentAmount)
      .while(keepGoing())
      .case(Donors,
        (() => {
          const Donate = declassify(interact.getPayment())
          const mDonate = (this != Fundraiser && this != publisher)
            ? declassify(interact.getAmount(currentAmount, object_amount, Donate))
            : Maybe(UInt).None();
          return ({
            when: maybe(mDonate, false, ((fund) => fund + currentAmount <= object_amount)),
            msg: fromSome(mDonate, 0),
          });
        }),
        ((Donate) => Donate),
        ((Donate) => {

          return [this, false, currentAmount + Donate];
        })
      )
      .timeRemaining(timeRemaining());

  each([Fundraiser,Donors,Receiver],() => 
    {
      interact.inform_DDL(balance());
    })


  transfer(balance()).to(Receiver)

  commit()


  Receiver.only(() => {
    interact.showBalance();
  })

  Receiver.publish();
  commit();
})


