package com.studyinghome.bootshop.util.baidu;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RadiusScope implements Serializable {
	private Double minLatitude;
	private Double maxLatitude;
	private Double minLongitude;
	private Double maxLongitude;
}
