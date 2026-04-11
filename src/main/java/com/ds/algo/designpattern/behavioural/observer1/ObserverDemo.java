package com.ds.algo.designpattern.behavioural.observer1;

/** Demo: Observer pattern – Subject notifies all attached Observers. */
public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer email = new EmailObserver();
        Observer sms   = new SMSObserver();

        subject.attach(email);
        subject.attach(sms);

        subject.setState("Order Created!");
        // Output:
        //   [Subject] State changed to: Order Created!
        //   [EmailObserver] Email received: Order Created!
        //   [SMSObserver] SMS received: Order Created!

        subject.detach(sms);
        subject.setState("Order Shipped!");
        // Only EmailObserver receives this one
    }
}
