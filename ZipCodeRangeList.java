package com.sample;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ZipCodeRangeList {

	private void sortRange(ArrayList<ZipCodeRange> rangeList) {
		Collections.sort(rangeList, new Comparator<ZipCodeRange>() {

			public int compare(ZipCodeRange range1, ZipCodeRange range2) {
				String r1 = range1.getFrom();
				String r2 = range2.getFrom();
				int comp = r1.compareTo(r2);
				if (comp != 0) {
					return comp;
				} else {
					String x1 = ((ZipCodeRange) range1).getTo();
					String x2 = ((ZipCodeRange) range2).getTo();
					return x1.compareTo(x2);
				}
			}

		});
	}

	public ArrayList<ZipCodeRange> mergeRange(ArrayList<ZipCodeRange> rangeList) {
		ArrayList<ZipCodeRange> mergedRangeList = new ArrayList<ZipCodeRange>();
		rangeList=validateZipCodes(rangeList);
		int rangeListSize = rangeList.size();
		if (rangeListSize > 0) {
			sortRange(rangeList);
			ZipCodeRange tmpObj = rangeList.get(0);
		
			for (int i = 0; i < rangeListSize; i++) {
				if ((Integer.parseInt(tmpObj.getTo()) + 1 == Integer.parseInt(rangeList.get(i).getFrom())
						|| Integer.parseInt(tmpObj.getTo()) >= Integer.parseInt(rangeList.get(i).getFrom()))) {

					if (Integer.parseInt(tmpObj.getTo()) < Integer.parseInt(rangeList.get(i).getTo())
							&& Integer.parseInt(tmpObj.getFrom()) != Integer.parseInt(rangeList.get(i).getFrom())) {
						tmpObj.setTo(rangeList.get(i).getTo());
					}

				} else {
					mergedRangeList.add(tmpObj);
					tmpObj = rangeList.get(i);
				}
			}
				mergedRangeList.add(tmpObj);
			return mergedRangeList;
		}else{
			return mergedRangeList;
		}
	}

	
	private boolean validateInput(int zipCode) {
		if (zipCode <= 99999)
			return true;
		return false;
	}
	
    private ArrayList<ZipCodeRange> validateZipCodes(ArrayList<ZipCodeRange> rangeList){
    	ArrayList<ZipCodeRange> zipCodeRangeList =new ArrayList();
    	for(ZipCodeRange zipCodeRange:rangeList){
	    	if (validateInput(Integer.parseInt(zipCodeRange.getFrom())) && validateInput(Integer.parseInt(zipCodeRange.getTo()))){
	    		ZipCodeRange range = null;
	    		
				if (Integer.parseInt(zipCodeRange.getFrom()) <= Integer.parseInt(zipCodeRange.getTo()))
					range = new ZipCodeRange(zipCodeRange.getFrom(), zipCodeRange.getTo());
				else
					range = new ZipCodeRange(zipCodeRange.getTo(), zipCodeRange.getFrom());

				zipCodeRangeList.add(range);
	    	}
    	}
    	return zipCodeRangeList;
    }
   
}
