package com.artur.templates.threadProducerConsumer;

/* 
Producer–consumer

Требования:
1. В методе run класса ConsumerTask должен содержаться synchronized блок, монитор - transferObject.
2. В методе run класса ProducerTask должен содержаться synchronized блок, монитор - transferObject.
3. Метод get класса TransferObject должен ждать появления value, и возвращать его после того, как оно появится.
4. Метод put класса TransferObject должен ждать пока value заберут и обновлять его значение после того, как оно пропадет.
5. Метод get класса TransferObject должен устанавливать флаг isValuePresent в false и уведомлять другие нити ожидающие освобождения монитора перед возвратом значение поля value.
6. Метод put класса TransferObject должен устанавливать флаг isValuePresent в true и уведомлять другие нити ожидающие освобождения монитора после обновления значение поля value.

*/
public class Solution {
    public static void main(String args[]) throws InterruptedException {
        TransferObject transferObject = new TransferObject();
        ProducerTask producerTask = new ProducerTask(transferObject);
        ConsumerTask consumerTask = new ConsumerTask(transferObject);

        Thread.sleep(50);
        producerTask.stop();
        consumerTask.stop();
    }
}
