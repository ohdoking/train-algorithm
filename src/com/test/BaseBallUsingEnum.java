package com.test;

import java.util.Random;

import com.test.BaseBallUsingEnum.Baseball.*;

public class BaseBallUsingEnum {

	enum Baseball{
		
		INIT(Strike.ZERO_STRIKE, Ball.ZERO_BALL);
		
		private Strike strike;
		private Ball ball;
		
		private Baseball(Strike strike, Ball ball) {
			this.strike = strike;
			this.ball = ball;
		}
		
		public Strike getStrike() {
			return strike;
		}
		
		public Ball getBall() {
			return ball;
		}
		
		enum Strike{
			ZERO_STRIKE {
				@Override
				Strike strike() {
					return Strike.ONE_STRIKE;
				}
			},
			ONE_STRIKE {
				@Override
				Strike strike() {
					return Strike.TWO_STRIKE;
				}
			}, TWO_STRIKE {
				@Override
				Strike strike() {
					return Strike.THREE_STRIKE;
				}
			}, THREE_STRIKE {
				@Override
				Strike strike() {
					return null;
				}
			};
			abstract Strike strike();
		}
		
		enum Ball{
			ZERO_BALL {
				@Override
				Ball ball() {
					return Ball.ONE_BALL;
				}
			},
			ONE_BALL {
				@Override
				Ball ball() {
					return Ball.TWO_BALL;
				}
			}, TWO_BALL {
				@Override
				Ball ball() {
					return Ball.THREE_BALL;
				}
			}, THREE_BALL {
				@Override
				Ball ball() {
					return Ball.FOUR_BALL;
				}
			}, FOUR_BALL {
				@Override
				Ball ball() {
					return null;
				}
			};
			abstract Ball ball();
		};
		
	}
	
	
	public static void main(String[] args) {
		
		Baseball baseball = Baseball.INIT;
		Strike strike = baseball.getStrike();
		Ball ball = baseball.getBall();
	
		Random r = new Random();
		int lowerBound = 0;
		int upperBound = 2;
		
		while(true) {
			if(strike == Strike.THREE_STRIKE || ball == Ball.FOUR_BALL) {
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