package example.nosql;

public class Item {
	public String _id;	//I_ID+I_IM_ID
	public String I_NAME;
	public int I_PRICE;
	public String I_DATA;
	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
	}
	/**
	 * @return the i_NAME
	 */
	public String getI_NAME() {
		return I_NAME;
	}
	/**
	 * @param i_NAME the i_NAME to set
	 */
	public void setI_NAME(String i_NAME) {
		I_NAME = i_NAME;
	}
	/**
	 * @return the i_PRICE
	 */
	public int getI_PRICE() {
		return I_PRICE;
	}
	/**
	 * @param i_PRICE the i_PRICE to set
	 */
	public void setI_PRICE(int i_PRICE) {
		I_PRICE = i_PRICE;
	}
	/**
	 * @return the i_DATA
	 */
	public String getI_DATA() {
		return I_DATA;
	}
	/**
	 * @param i_DATA the i_DATA to set
	 */
	public void setI_DATA(String i_DATA) {
		I_DATA = i_DATA;
	}
	
}
