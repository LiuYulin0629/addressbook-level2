package seedu.addressbook.data.person;

public class Block {
	private String _block;
	public Block(String blockNumber){
		setBlockNumber(blockNumber);
	}
	public String getBlockNumber(){
		return _block;
	}
	public void setBlockNumber(String blockNumber){
		this._block = blockNumber;
	}
}
