package example.nosql;

public class Order {
	public String _id;	//O_ID+O_D_ID+O_W_ID+O_C_ID
	public String O_ENTRY_D;	
	public String O_CARRIER_ID;
	public int O_OL_CNT;
	public int O_ALL_LOCAL;
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
	 * @return the o_ENTRY_D
	 */
	public String getO_ENTRY_D() {
		return O_ENTRY_D;
	}
	/**
	 * @param o_ENTRY_D the o_ENTRY_D to set
	 */
	public void setO_ENTRY_D(String o_ENTRY_D) {
		O_ENTRY_D = o_ENTRY_D;
	}
	/**
	 * @return the o_CARRIER_ID
	 */
	public String getO_CARRIER_ID() {
		return O_CARRIER_ID;
	}
	/**
	 * @param o_CARRIER_ID the o_CARRIER_ID to set
	 */
	public void setO_CARRIER_ID(String o_CARRIER_ID) {
		O_CARRIER_ID = o_CARRIER_ID;
	}
	/**
	 * @return the o_OL_CNT
	 */
	public int getO_OL_CNT() {
		return O_OL_CNT;
	}
	/**
	 * @param o_OL_CNT the o_OL_CNT to set
	 */
	public void setO_OL_CNT(int o_OL_CNT) {
		O_OL_CNT = o_OL_CNT;
	}
	/**
	 * @return the o_ALL_LOCAL
	 */
	public int getO_ALL_LOCAL() {
		return O_ALL_LOCAL;
	}
	/**
	 * @param o_ALL_LOCAL the o_ALL_LOCAL to set
	 */
	public void setO_ALL_LOCAL(int o_ALL_LOCAL) {
		O_ALL_LOCAL = o_ALL_LOCAL;
	}
	
}
