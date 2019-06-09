/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codenergic.akinatorj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Elements {
	private Element element;

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public static class Element {
		private String id;
		private String name;
		private String idBase;
		private String proba;
		private String description;
		private String valideContrainte;
		private String ranking;
		private String minibaseAddable;
		private String relativeId;
		private String pseudo;
		private String picturePath;
		private String absolutePicturePath;

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

		@JsonProperty("id_base")
		public String getIdBase() {
			return idBase;
		}

		public void setIdBase(String idBase) {
			this.idBase = idBase;
		}

		public String getProba() {
			return proba;
		}

		public void setProba(String proba) {
			this.proba = proba;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		@JsonProperty("valide_contrainte")
		public String getValideContrainte() {
			return valideContrainte;
		}

		public void setValideContrainte(String valideContrainte) {
			this.valideContrainte = valideContrainte;
		}

		public String getRanking() {
			return ranking;
		}

		public void setRanking(String ranking) {
			this.ranking = ranking;
		}

		@JsonProperty("minibase_addable")
		public String getMinibaseAddable() {
			return minibaseAddable;
		}

		public void setMinibaseAddable(String minibaseAddable) {
			this.minibaseAddable = minibaseAddable;
		}

		@JsonProperty("relative_id")
		public String getRelativeId() {
			return relativeId;
		}

		public void setRelativeId(String relativeId) {
			this.relativeId = relativeId;
		}

		public String getPseudo() {
			return pseudo;
		}

		public void setPseudo(String pseudo) {
			this.pseudo = pseudo;
		}

		@JsonProperty("picture_path")
		public String getPicturePath() {
			return picturePath;
		}

		public void setPicturePath(String picturePath) {
			this.picturePath = picturePath;
		}

		@JsonProperty("absolute_picture_path")
		public String getAbsolutePicturePath() {
			return absolutePicturePath;
		}

		public void setAbsolutePicturePath(String absolutePicturePath) {
			this.absolutePicturePath = absolutePicturePath;
		}
	}
}
