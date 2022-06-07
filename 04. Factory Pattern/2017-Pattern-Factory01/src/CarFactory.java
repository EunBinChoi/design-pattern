import Vehicle.Color;

/**
* 객체지향개발론 및 실습 2017학년도 1학기 실습 4. Factory Method 패턴
* @editor최은빈(컴퓨터공학부 2014136129) 
* 일반승용차량을 생산하는 Concrete Creator 클래스
*/
public class CarFactory extends VehicleFactory {
	// 일반 승용 차량을 생성할 때 사용됨
	@Override
	protected Vehicle selectVehicle(DrivingStyle style) {
		switch(style){
		case MIDRANGE:
			return new Compact("KIA K5");
		case POWERFUL:
			return new Sports("Hyundai Genesis Coupe");
		case LUXURY:
			return new Saloon("Renault Samsung S7");
		default:
			throw new IllegalArgumentException("DrivingStyle not supported");
		}
	}

	@Override
	protected int addCost(Color color) {
		// TODO Auto-generated method stub
		return 0;
	}
}

