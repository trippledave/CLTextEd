class replaceNewlineAndCR implements TextCommandInterface {

	@Override
	public String formatText(String input, String option) {
		input.replace("\n", "");
		input.replace("\r", " ");
		return input;
	}
}

class splitAfterFirstSpace implements TextCommandInterface {

	@Override
	public String formatText(String input, String option) {
		int index=input.indexOf(" ");
		//+1 to ignore the Space
		input=input.substring(index+1);
		return input;
	}
}

class addAtLineEnd implements TextCommandInterface {

	@Override
	public String formatText(String input, String option) {
		input=input+option;		
		return input;
	}
}
