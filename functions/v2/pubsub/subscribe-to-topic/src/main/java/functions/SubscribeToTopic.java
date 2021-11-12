/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package functions;

// [START functions_log_cloudevent]
import com.google.cloud.functions.CloudEventsFunction;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.cloudevents.CloudEvent;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.logging.Logger;

public class SubscribeToTopic implements CloudEventsFunction {
  private static final Logger logger = Logger.getLogger(SubscribeToTopic.class.getName());

  @Override
  public void accept(CloudEvent event) {
    logger.info("Event: " + event.getId());
    logger.info("Event Attribute Names: " + event.getAttributeNames().toString());
    //    console.log('API method:', cloudevent.methodname);
    logger.info("Event Type: " + event.getType());
    logger.info("Event Subject: " + event.getSubject());

    if (event.getData() != null) {
      String cloudEventData = new String(event.getData().toBytes(), StandardCharsets.UTF_8);

      Gson gson = new Gson();
      JsonObject eventData = gson.fromJson(cloudEventData, JsonObject.class);
      System.out.println(gson.toJson(eventData));
      //      console.log('Resource name:', payload.resourceName);

//       Retrieve PubSub message data
//      String encodedData = body.getMessage().getData();
//      String decodedData =
//              new String(Base64.getDecoder().decode(encodedData), StandardCharsets.UTF_8);
//      logger.info("Event data: " + decodedData);
    }

//    // Print out details from the Cloud Audit Logging entry
//    }
//
//  const request = payload.request;
//    if (request) {
//      console.log('Request type:', request['@type']);
//    }
//
//  const metadata = payload && payload.requestMetadata;
//    if (metadata) {
//      console.log('Caller IP:', metadata.callerIp);
//      console.log('User agent:', metadata.callerSuppliedUserAgent);
//    }
  }
}
// [END functions_log_cloudevent]
