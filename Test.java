package com.sample;
import java.util.ArrayList;
public class Test {
public static void main(String args[]){
	
	ZipCodeRangeList zipRange=new ZipCodeRangeList();
	ArrayList<ZipCodeRange> al=new ArrayList();
	ZipCodeRange range=new ZipCodeRange();
	range.setFrom("94133");
	range.setTo("94189");
	
	ZipCodeRange range1=new ZipCodeRange();
	range1.setFrom("94200");
	range1.setTo("94299");
	
	ZipCodeRange range2=new ZipCodeRange();
	range2.setFrom("94226");
	range2.setTo("94399");
	
	al.add(range);
	al.add(range1);
	al.add(range2);
	
	ArrayList<ZipCodeRange>  result=zipRange.mergeRange(al);
	
	
	for(ZipCodeRange obj:result){
		System.out.println(obj.getFrom()+" : Range :"+obj.getTo());
	}
	
}
}
