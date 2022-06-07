/**
* 객체지향개발론 및 실습 2017학년도 1학기 실습 4. Factory Method 패턴
* @editor최은빈(컴퓨터공학부 2014136129) 
* 차량을 생산하는 Abstract Creator 클래스
*/
public abstract class VehicleFactory {
	public enum DrivingStyle {ECONOMICAL, MIDRANGE, LUXURY, POWERFUL};
	
	public final Vehicle build(DrivingStyle style, Vehicle.Color color){
		Vehicle v = selectVehicle(style);
		//예외발생가능, 이 스타일의 차가 팩토리안에서 제공되지 않을 수 있음
		v.paint(color);
		v.cost(color);
		return v;
	}
	
	
	/*[두 가지 고민] 
	 * 1.selectVehicle 메소드가 왜 protected로 선언되었을까?
	 * 
	 * 이 메소드가 protected로 선언되어있는 이유는
	 * 외부에서 전혀 사용하지 않고, VehicleFactory 클래스의 메소드인 build()에서 활용되는 부분이기 때문이다*/
	protected abstract Vehicle selectVehicle(DrivingStyle style);
	protected abstract int addCost(Vehicle.Color color);
}
