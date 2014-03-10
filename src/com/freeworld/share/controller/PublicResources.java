package com.freeworld.share.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.freeworld.share.entity.Announcement;

@Named
@ApplicationScoped
public class PublicResources implements Serializable{

	private static final long serialVersionUID = -5359001408691488118L;

	private List<Announcement> pubAnnounce = new ArrayList<>();

		
	public List<Announcement> getPubAnnounce() {
		return pubAnnounce;
	}

	public void setPubAnnounce(List<Announcement> pubAnnounce) {
		this.pubAnnounce = pubAnnounce;
	}
}
