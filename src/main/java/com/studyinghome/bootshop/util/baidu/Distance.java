package com.studyinghome.bootshop.util.baidu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Distance implements Serializable {
	private String distanceText;
	private int distanceNum;
	private String durationText;
	private int durationNum;

}
