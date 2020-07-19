package com.comp.prog;

/**
 * Given numBottles full water bottles, you can exchange numExchange empty water
 * bottles for one full water bottle.
 * 
 * The operation of drinking a full water bottle turns it into an empty bottle.
 * 
 * Return the maximum number of water bottles you can drink.
 */
public class WatterBottles {

	public static void main(String[] args) {
		System.out.println(numWaterBottles(15, 4));
	}

	public static int numWaterBottles(int numBottles, int numExchange) {
		int result = numBottles;
		int reminder = 0;
		while (numBottles >= numExchange) {
			result = numBottles / numExchange + result;
			reminder = numBottles % numExchange;
			numBottles = (numBottles / numExchange) + reminder;
		}
		return result;
	}
}
