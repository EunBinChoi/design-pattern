// 디버깅을 위한 콘솔 문자열 출력이 필요 없는 경우
// 기본 메소드를 구현하면, 각 상태를 구현하기 편리해질 수 있음
public enum DoorState2 {
	OPENED{
		@Override
		public DoorState2 close() {
			return CLOSED;
		}
	}, 
	CLOSED{
		@Override
		public DoorState2 open() {
			return OPENED;
		}
		@Override
		public DoorState2 lock() {
			return LOCKED;
		}
	}, 
	LOCKED{
		@Override
		public DoorState2 unlock() {
			return CLOSED;
		}
	};
	public DoorState2 open(){ return this; }
	public DoorState2 close(){ return this; }
	public DoorState2 lock(){ return this; }
	public DoorState2 unlock(){ return this; }
}
