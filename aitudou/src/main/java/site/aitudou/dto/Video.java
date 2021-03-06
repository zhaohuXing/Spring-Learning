package site.aitudou.dto;

public class Video {

	/* 视频名称 */
	private String title;
	
	/* 视频图片 */
	private String image;
	
	/* 视频播放地址 */
	private String playUrl;
	
	/* 视频类型 */
	private String type;
	
	/* [版权] 视频源地址 */
	private String value;

	/* [版权] 视频提供方 */
	private String provider;

	/* [版权] 视频解析方 */
	private String parserName;

	/* [版权] 视频解析方官网 */
	private String parser;

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setPlayUrl(String playUrl) {
		this.playUrl = playUrl;
	}

	public String getPlayUrl() {
		return playUrl;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProvider() {
		return provider;
	}

	public void setParserName(String parserName) {
		this.parserName = parserName;
	} 

	public String getParserName() {
		return parserName;
	}

	public void setParser(String parser) {
		this.parser = parser;
	} 

	public String getParser() {
		return parser;
	}
}
