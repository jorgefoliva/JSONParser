package es.beans;

import java.util.List;

public class ProductBean {

	private String id;
	private String name;
	private List<String> sizes;
	private List<FeatureBean> features;
	private DataBean data;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSizes() {
		return sizes;
	}

	public void setSizes(List<String> sizes) {
		this.sizes = sizes;
	}

	public List<FeatureBean> getFeatures() {
		return features;
	}

	public void setFeatures(List<FeatureBean> features) {
		this.features = features;
	}

	public DataBean getData() {
		return data;
	}

	public void setData(DataBean data) {
		this.data = data;
	}
}
