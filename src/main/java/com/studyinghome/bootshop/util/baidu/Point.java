package com.studyinghome.bootshop.util.baidu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Point implements Serializable {
	private double lng;
	private double lat;
	private String address;
}
