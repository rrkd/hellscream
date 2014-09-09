package au.com.iglooit.hellscream.service.quote;

import au.com.iglooit.hellscream.model.entity.Quote;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 6/09/2014
 * Time: 2:08 PM
 */
public interface QuoteService {
    Map<String, List<Quote>> loadUserQuoteList(String email);
}
