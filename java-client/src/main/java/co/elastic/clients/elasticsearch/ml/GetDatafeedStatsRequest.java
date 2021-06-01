/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package co.elastic.clients.elasticsearch.ml;

import co.elastic.clients.base.ElasticsearchError;
import co.elastic.clients.base.Endpoint;
import co.elastic.clients.elasticsearch._types.RequestBase;
import co.elastic.clients.json.JsonpObjectBuilderParser;
import co.elastic.clients.json.JsonpObjectParser;
import co.elastic.clients.json.JsonpValueParser;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.Boolean;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

// typedef: ml.get_datafeed_stats.Request
public final class GetDatafeedStatsRequest extends RequestBase {
	@Nullable
	private final List<String> datafeedId;

	@Nullable
	private final Boolean allowNoDatafeeds;

	// ---------------------------------------------------------------------------------------------

	protected GetDatafeedStatsRequest(Builder builder) {

		this.datafeedId = builder.datafeedId;
		this.allowNoDatafeeds = builder.allowNoDatafeeds;

	}

	/**
	 * API name: {@code datafeed_id}
	 */
	@Nullable
	public List<String> datafeedId() {
		return this.datafeedId;
	}

	/**
	 * API name: {@code allow_no_datafeeds}
	 */
	@Nullable
	public Boolean allowNoDatafeeds() {
		return this.allowNoDatafeeds;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetDatafeedStatsRequest}.
	 */
	public static class Builder implements ObjectBuilder<GetDatafeedStatsRequest> {
		@Nullable
		private List<String> datafeedId;

		@Nullable
		private Boolean allowNoDatafeeds;

		/**
		 * API name: {@code datafeed_id}
		 */
		public Builder datafeedId(@Nullable List<String> value) {
			this.datafeedId = value;
			return this;
		}

		/**
		 * API name: {@code datafeed_id}
		 */
		public Builder datafeedId(String... value) {
			this.datafeedId = Arrays.asList(value);
			return this;
		}

		/**
		 * Add a value to {@link #datafeedId(List)}, creating the list if needed.
		 */
		public Builder addDatafeedId(String value) {
			if (this.datafeedId == null) {
				this.datafeedId = new ArrayList<>();
			}
			this.datafeedId.add(value);
			return this;
		}

		/**
		 * API name: {@code allow_no_datafeeds}
		 */
		public Builder allowNoDatafeeds(@Nullable Boolean value) {
			this.allowNoDatafeeds = value;
			return this;
		}

		/**
		 * Builds a {@link GetDatafeedStatsRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetDatafeedStatsRequest build() {

			return new GetDatafeedStatsRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code ml.get_datafeed_stats}".
	 */
	public static final Endpoint<GetDatafeedStatsRequest, GetDatafeedStatsResponse, ElasticsearchError> ENDPOINT = new Endpoint.Simple<>(
			// Request method
			request -> "GET",

			// Request path
			request -> {
				StringBuilder buf = new StringBuilder();
				buf.append("/_ml");
				buf.append("/datafeeds");
				if (request.datafeedId != null) {
					buf.append("/");
					buf.append(request.datafeedId.stream().map(v -> v).collect(Collectors.joining(",")));
				}
				buf.append("/_stats");
				return buf.toString();

			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				if (request.allowNoDatafeeds != null) {
					params.put("allow_no_datafeeds", String.valueOf(request.allowNoDatafeeds));
				}
				return params;

			}, Endpoint.Simple.emptyMap(), false, GetDatafeedStatsResponse.JSONP_PARSER);
}