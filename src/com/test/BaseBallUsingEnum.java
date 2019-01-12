package com.test;

import java.util.Random;

import com.test.BaseBallUsingEnum.Baseball.*;

public class BaseBallUsingEnum {

	enum Baseball{
		
		INIT;
		
		enum STRIKE{
			ZERO_STRIKE {
				@Override
				STRIKE strike() {
					return STRIKE.ONE_STRIKE;
				}
			},
			ONE_STRIKE {
				@Override
				STRIKE strike() {
					return STRIKE.TWO_STRIKE;
				}
			}, TWO_STRIKE {
				@Override
				STRIKE strike() {
					return STRIKE.THREE_STRIKE;
				}
			}, THREE_STRIKE {
				@Override
				STRIKE strike() {
					return null;
				}
			};
			abstract STRIKE strike();
		}
		
		enum BALL{
			ZERO_BALL {
				@Override
				BALL ball() {
					return BALL.ONE_BALL;
				}
			},
			ONE_BALL {
				@Override
				BALL ball() {
					return BALL.TWO_BALL;
				}
			}, TWO_BALL {
				@Override
				BALL ball() {
					return BALL.THREE_BALL;
				}
			}, THREE_BALL {
				@Override
				BALL ball() {
					return BALL.FOUR_BALL;
				}
			}, FOUR_BALL {
				@Override
				BALL ball() {
					return null;
				}
			};
			abstract BALL ball();
		};
		
	}
	
	
	public static void main(String[] args) {
		
		STRIKE strike = STRIKE.ZERO_STRIKE;
		BALL ball = BALL.ZERO_BALL;
	
		Random r = new Random();
		int lowerBound = 0;
		int upperBound = 2;
		
		while(true) {
			if(strike == STRIKE.THREE_STRIKE || ball == BALL.FOUR_BALL) {
				System.out.println(strike.toString() + " / " + ball.toString());
				break;
			}
			int ran = r.nextInt(upperBound-lowerBound) + lowerBound;
			if(ran == 0) {
				strike = strike.strike();
			}
			else {
				ball = ball.ball();
			}
		}
	}
}