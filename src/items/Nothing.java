package items;

import items.base.BaseItem;

public class Nothing extends BaseItem{

	public Nothing() {
		setName("Nothing");
		typeItem = new BaseItem() {
			
			@Override
			public int use() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	}
	@Override
	public int use() {
		return 0;
	}
}
