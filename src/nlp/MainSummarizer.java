package nlp;

import java.util.ArrayList;


public class MainSummarizer {
    
    public static void main (String[] args) {
    	ArrayList<String> key_sentences = new ArrayList<String>();
    	ArrayList<String> result = new GetContent().getContent();
    	
        Ranker ranker;
        ranker = new PageRankRanker();
        
        for(int i=0; i<result.size(); i++) {
        	Summarizer summarizer = new Summarizer(result.get(i), ranker);
        	key_sentences.add(summarizer.fileSummarize().get(0));
        }
               
        //Sentences of each email in the thread
        for(int index=0; index<result.size(); index++) {
        	System.out.println("++++++++++++++++++++++");
        	System.out.println(result.get(index));
        }
        
        //keysentences of each email
        System.out.println("======================");
        for(int m=0; m<key_sentences.size(); m++) {	
        	System.out.println(key_sentences.get(m)); 
        }
        
        //The topic for the whole thread selected from the thread
        System.out.println("______________________");
        
        ArrayList<String> topic = new SimilarDegreeByCos().Compare(key_sentences);
//        System.out.println(topic.get(2));
        for(int m=0; m<topic.size(); m++ ) {
        	System.out.println(topic.get(m));
        }
      
        System.out.println("Summarization Done!");

    }
    
//    /** Read the whole input file content*/
//
//    private static String readFileToString(String infile) {
//        
//        try {
//            
//            BufferedReader reader = new BufferedReader(new FileReader(infile));
//            
//            String result ="";
//            
//            String line = reader.readLine();
//            
//            while (line != null) {
//                
//                result = result + line + '\n';
//                
//                line = reader.readLine();
//                
//            }
//            
//            reader.close();
//            
//            return result;
//            
//        } catch(IOException ex) {
//            
//            System.out.println(ex); //handle file not found by displaying message
//            
//            return ""; //return the empty string if file not fount
//            
//        }
//        
//    }
}
