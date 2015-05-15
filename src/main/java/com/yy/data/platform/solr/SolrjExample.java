package com.yy.data.platform.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

public class SolrjExample {

	private SolrServer solrServer;

	public SolrjExample(String solrUrl) {
		solrServer = new HttpSolrServer(solrUrl);
	}

	public SearchResult<Article> search(String keyWord, String searchField,
			int pageNum, int pageSize, boolean isHighLight,
			String highLightPrefix, String highLightSuffix,
			String highLightFields, int highLightLimit)
			throws SolrServerException {
		SolrQuery query = new SolrQuery();
		query.setStart(pageNum * pageSize);
		query.setRows(pageNum);
		query.setQuery(searchField + ":" + keyWord);
		if (isHighLight) {
			query.setHighlight(isHighLight);
			query.setHighlightFragsize(highLightLimit);
			query.setHighlightSimplePre(highLightPrefix);
			query.setHighlightSimplePost(highLightSuffix);
			query.setParam("hl.fl", highLightFields);
		}
		System.out.println(query);
		QueryResponse response = solrServer.query(query);
		SolrDocumentList docList = response.getResults();
		Map<String, Map<String, List<String>>> highLights = null;
		if (isHighLight) {
			highLights = response.getHighlighting();
		}
		List<Article> articles = new ArrayList<Article>();
		if (docList.isEmpty()) {
			return new SearchResult<Article>(0, articles);
		}
		for (SolrDocument doc : docList) {
			articles.add(createArticle(doc, highLights));
		}
		return new SearchResult<Article>(docList.getNumFound(), articles);
	}

	public SearchResult<Article> search(String keyWord, String searchField,
			int pageNum, int pageSize, boolean isHighLight)
			throws SolrServerException {
		return search(keyWord, searchField, pageNum, pageSize, isHighLight,
				"<font color='red'>", "</font>", "title,content", 100);
	}

	public void index(List<Article> articles) throws SolrServerException, IOException{
		List<SolrInputDocument> documents = new ArrayList<SolrInputDocument>();
		for(Article article:articles){
			documents.add(getDocument(article));
		}
		solrServer.add(documents);
	}
	
	private SolrInputDocument getDocument(Article article) {
		
		return null;
	}

	private Article createArticle(SolrDocument doc,
			Map<String, Map<String, List<String>>> highLights) {
		Article article = new Article();
		article.setId(doc.getFieldValue("id").toString());
		article.setContent(doc.getFieldValue("content").toString());
		article.setTitle(doc.getFieldValue("title").toString());
		if (highLights != null && highLights.size() != 0) {
			if (highLights.get(article.getId()) != null)
				article.setContentHightLights(highLights.get(article.getId())
						.get("content"));
		}
		return article;
	}

	public static void main(String[] args) throws SolrServerException {
		SolrjExample solr = new SolrjExample("http://192.168.1.202:18080/solr");
		SearchResult<Article> articles = solr.search("我们","text", 10, 0,true);
		for (Article article : articles.getResultList()) {
			System.out.println(article.getId() + "," + article.getTitle() + ","
					+ article.getContentHightLights().get(0));
		}

	}
}
