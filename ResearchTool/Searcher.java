
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Searcher
{
	static Searcher main;
	
    private static final String GOOGLE_SEARCH_URL = "https://www.google.com/search?q=";

    // http://www.google.com/search?q=abc+def searches for "abc def"
    private GUI gui;

    private Article[] articles;

    private String[] newsNames = { "a", "b", "c" };

    private double[] newsCred = { 4.5, 5, 4 };


    public Searcher()
    {
        //does absolutely fin nothing
    	//Not anymore
    	if (main == null) main=this;
		else {
			System.out.println("ERROR: SEARCHER SINGLETON BREACHED");
		}
    }


    public void setGUI( GUI gui )
    {
        this.gui = gui;
    }


    /**
     * 
     * Gets the required amount of sources and loads info into class variable
     * 
     * @param amount
     *            of sources you want
     */
    public void getSources( String searchterm, int amount )
    {
        String[] searchTerms = searchterm.split( " " );
        String searchURL = GOOGLE_SEARCH_URL;
        for(int i = 0; i < searchTerms.length; i++) {
            searchURL += searchTerms[i];
            if(i != searchTerms.length) {
                searchURL+= "+";
            }
        }
        searchURL += "&nums=";
        searchURL += ("" + amount);
        
        
        //String searchURL = GOOGLE_SEARCH_URL + "?q="+searchTerm+"&num="+num;
        //without proper User-Agent, we will get 403 error
        //Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
    }


    /**
     * 
     * Returns an article from articles. If article num exceeds the length of
     * the list, null is returned
     * 
     * @param articleNum
     * @return
     */
    public Article getArticle( int articleNum )
    {
        if ( articleNum >= articles.length )
        {
            return null;
        }
        return articles[articleNum];
    }
}
