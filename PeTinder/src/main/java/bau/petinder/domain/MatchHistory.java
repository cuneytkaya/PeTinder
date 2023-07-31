package bau.petinder.domain;

public class MatchHistory extends BaseEntity {
	
	private int sourceCustomerId;
    private int sourcePetId;
    private int targetPetId;
    private boolean isMatchSelected;

    public int getSourcePetId() {
        return sourcePetId;
    }

    public void setSourcePetId(int sourcePetId) {
        this.sourcePetId = sourcePetId;
    }

    public int getTargetPetId() {
        return targetPetId;
    }

    public void setTargetPetId(int targetPetId) {
        this.targetPetId = targetPetId;
    }

    public boolean isMatchSelected() {
        return isMatchSelected;
    }

    public void setMatchSelected(boolean matchSelected) {
        isMatchSelected = matchSelected;
    }
    public int getSourceCustomerId() {
	    return sourceCustomerId;
	}

	public void setSourceCustomerId(int sourceCustomerId) {
	    this.sourceCustomerId = sourceCustomerId;
	}
}


