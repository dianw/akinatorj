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

import java.io.Serializable;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Value.Immutable
@JsonDeserialize(builder = ImmutableElement.Builder.class)
public interface Element extends Serializable {
	@JsonProperty("absolute_picture_path")
	String getAbsolutePicturePath();

	String getCorrupt();

	String getDescription();

	@JsonProperty("flag_photo")
	String getFlagPhoto();

	String getId();

	@JsonProperty("id_base")
	String getIdBase();

	@Value.Default
	@JsonProperty("minibase_addable")
	default String getMinibaseAddable() {
		return "";
	}

	String getName();

	@JsonProperty("picture_path")
	String getPicturePath();

	String getProba();

	String getPseudo();

	String getRanking();

	String getRelative();

	@Value.Default
	@JsonProperty("relative_id")
	default String getRelativeId() {
		return "";
	}

	@JsonProperty("valide_contrainte")
	String getValideContrainte();
}
