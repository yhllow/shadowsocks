/**
 * @Title: Section.java
 * @Package com.ineng.shadowsocks
 * @Description: TODO(用一句话描述该文件做什么)
 * @author yh
 * @date 2016年6月9日 下午8:43:20
 * @version V1.0
 */
package com.ineng.shadowsocks.model;

import org.htmlparser.tags.CompositeTag;

public class Section extends CompositeTag {
	/**
	 * The set of names handled by this tag.
	 */
	private static final String[] mIds = new String[] { "SECTION" };

	/**
	 * The set of end tag names that indicate the end of this tag.
	 */
	private static final String[] mEndTagEnders = new String[] { "BODY", "HTML" };

	/**
	 * Create a new div tag.
	 */
	public Section() {
	}

	/**
	 * Return the set of names handled by this tag.
	 * @return The names to be matched that create tags of this type.
	 */
	public String[] getIds() {
		return (mIds);
	}

	/**
	 * Return the set of end tag names that cause this tag to finish.
	 * @return The names of following end tags that stop further scanning.
	 */
	public String[] getEndTagEnders() {
		return (mEndTagEnders);
	}
}
