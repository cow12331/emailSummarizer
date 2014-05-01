package nlp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SimilarDegreeByCos {
	public SimilarDegreeByCos() {}

	public static double getSimilarDegree(String str1, String str2) {
		Map<String, int[]> vectorSpace = new HashMap<String, int[]>();
		int[] itemCountArray = null;

		String strArray[] = str1.split(" ");
		for (int i = 0; i < strArray.length; ++i) {
			if (vectorSpace.containsKey(strArray[i]))
				++(vectorSpace.get(strArray[i])[0]);
			else {
				itemCountArray = new int[2];
				itemCountArray[0] = 1;
				itemCountArray[1] = 0;
				vectorSpace.put(strArray[i], itemCountArray);
			}
		}

		strArray = str2.split(" ");
		for (int i = 0; i < strArray.length; ++i) {
			if (vectorSpace.containsKey(strArray[i]))
				++(vectorSpace.get(strArray[i])[1]);
			else {
				itemCountArray = new int[2];
				itemCountArray[0] = 0;
				itemCountArray[1] = 1;
				vectorSpace.put(strArray[i], itemCountArray);
			}
		}

		double vector1Modulo = 0.00;
		double vector2Modulo = 0.00;
		double vectorProduct = 0.00;
		Iterator iter = vectorSpace.entrySet().iterator();

		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			itemCountArray = (int[]) entry.getValue();

			vector1Modulo += itemCountArray[0] * itemCountArray[0];
			vector2Modulo += itemCountArray[1] * itemCountArray[1];

			vectorProduct += itemCountArray[0] * itemCountArray[1];
		}

		vector1Modulo = Math.sqrt(vector1Modulo);
		vector2Modulo = Math.sqrt(vector2Modulo);

		return (vectorProduct / (vector1Modulo * vector2Modulo));
	}

//	public static void main(String args[]) {
//		int i;
//		double max = 0;
//
//		// str[0] = "I am a student";
//		// str[1] = "gold silver truck";
//		// str[2] = "Shipment of gold damaged in a fire";
//		// str[3] = "Delivery of silver arrived in a silver truck";
//		// str[4] = "Shipment of gold arrived in a truck";
//		// str[5] = "gold gold gold gold gold gold";
//		String str0 = "I am a student";
//		String str1 = "gold silver truck";
//		String str2 = "Shipment of gold damaged in a fire";
//		String str3 = "Delivery of silver arrived in a silver truck";
//		String str4 = "Shipment of gold arrived in a truck";
//		String str5 = "gold gold gold gold gold gold";
//		ArrayList<String> testSentence = new ArrayList<String>();
//		testSentence.add(str0);
//		testSentence.add(str1);
//		testSentence.add(str2);
//		testSentence.add(str3);
//		testSentence.add(str4);
//		testSentence.add(str5);
		
		
		
		
		public ArrayList<String> Compare(ArrayList<String> strs) {
		
		ArrayList<String> testSentence = strs;
		double max = 0.00000;
		
		int length = testSentence.size();
		String str[] = new String[length];
		double point[] = new double[length];
		/**
		 * for (i=0; i<length; i++){ testSentence.add(str[i]); }
		 */

		// testSentence.get(index)

		for (int i = 0; i < length; i++) {
			double sum = 0;
			for (int j = 0; j < length; j++) {
				if (i == j)
					break;
				else {
					sum = sum
							+ SimilarDegreeByCos.getSimilarDegree(testSentence.get(i),
									testSentence.get(j));
				}
			}
			point[i] = sum;
		}

		ArrayList<String> summaries = new ArrayList<String>();
		int count = 0;
		if(length == 0) {
			return null;
		} else if (length>0 && length<4) {
			count = 1;
		} else if (length >=4 && length<14) {
			count = 2;
		} else if (length>=14) {
			count = 3;
		}
		
		for(int i=0; i<count; i++) {
			max = 0.00000;
			
			for (int j = 0; j < length; j++) {
				max = point[j] > max ? point[j] : max;
			}

			for (int k = 0; k < length; k++) {
				if (point[k] == max) {
//					System.out.print(testSentence.get(k));
					summaries.add(testSentence.get(k));
					point[k] = 0.00000;
				}
			}
		}
		
		return summaries;
		// System.out.println(SimilarDegreeByCos.getSimilarDegree(str1, str3));
		// System.out.println(SimilarDegreeByCos.getSimilarDegree(str1, str4));
		// System.out.println(SimilarDegreeByCos.getSimilarDegree(str1, str5));
	}
}