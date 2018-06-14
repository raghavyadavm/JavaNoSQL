package example.nosql;

public class OrderLine {

	public String _id;	//OL_O_ID+OL_D_ID+H_C_W_ID+H_D_ID+H_W_ID
	public String OL_DELIVERY_D;
	public int OL_QUANTITY;
	public int OL_AMOUNT;
	public String OL_DIST_INFO;
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
	 * @return the oL_DELIVERY_D
	 */
	public String getOL_DELIVERY_D() {
		return OL_DELIVERY_D;
	}
	/**
	 * @param oL_DELIVERY_D the oL_DELIVERY_D to set
	 */
	public void setOL_DELIVERY_D(String oL_DELIVERY_D) {
		OL_DELIVERY_D = oL_DELIVERY_D;
	}
	/**
	 * @return the oL_QUANTITY
	 */
	public int getOL_QUANTITY() {
		return OL_QUANTITY;
	}
	/**
	 * @param oL_QUANTITY the oL_QUANTITY to set
	 */
	public void setOL_QUANTITY(int oL_QUANTITY) {
		OL_QUANTITY = oL_QUANTITY;
	}
	/**
	 * @return the oL_AMOUNT
	 */
	public int getOL_AMOUNT() {
		return OL_AMOUNT;
	}
	/**
	 * @param oL_AMOUNT the oL_AMOUNT to set
	 */
	public void setOL_AMOUNT(int oL_AMOUNT) {
		OL_AMOUNT = oL_AMOUNT;
	}
	/**
	 * @return the oL_DIST_INFO
	 */
	public String getOL_DIST_INFO() {
		return OL_DIST_INFO;
	}
	/**
	 * @param oL_DIST_INFO the oL_DIST_INFO to set
	 */
	public void setOL_DIST_INFO(String oL_DIST_INFO) {
		OL_DIST_INFO = oL_DIST_INFO;
	}
	
}
