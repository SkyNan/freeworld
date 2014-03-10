package com.freeworld.share.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.freeworld.share.entity.Announcement;

@Stateless
public class AnnouncementBean extends BaseBean{

	@SuppressWarnings("unchecked")
	public List<Announcement> findPublicAnnounce(int limit){
		String sql = "select announcement from Announcement announcement order by announcement.createdate where announcement.pub=true";
		Query query=em.createQuery(sql);
		return query.setMaxResults(limit).getResultList();
	}
}
