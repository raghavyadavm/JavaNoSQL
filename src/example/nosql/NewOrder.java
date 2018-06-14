package example.nosql;

public class NewOrder {
	public String _id;	//NO_ID+NO_D_ID+NO_W_ID
	public String H_DATE;
	public int H_AMOUNT;
	public String H_DATA;
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
	 * @return the h_DATE
	 */
	public String getH_DATE() {
		return H_DATE;
	}
	/**
	 * @param h_DATE the h_DATE to set
	 */
	public void setH_DATE(String h_DATE) {
		H_DATE = h_DATE;
	}
	/**
	 * @return the h_AMOUNT
	 */
	public int getH_AMOUNT() {
		return H_AMOUNT;
	}
	/**
	 * @param h_AMOUNT the h_AMOUNT to set
	 */
	public void setH_AMOUNT(int h_AMOUNT) {
		H_AMOUNT = h_AMOUNT;
	}
	/**
	 * @return the h_DATA
	 */
	public String getH_DATA() {
		return H_DATA;
	}
	/**
	 * @param h_DATA the h_DATA to set
	 */
	public void setH_DATA(String h_DATA) {
		H_DATA = h_DATA;
	}

}
