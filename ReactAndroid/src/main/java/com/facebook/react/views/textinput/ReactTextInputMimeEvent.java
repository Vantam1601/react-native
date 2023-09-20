/**
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * Event emitted by EditText native view when text changes.
 * VisibleForTesting from {@link TextInputEventsTestCase}.
 */
public class ReactTextInputMimeEvent extends Event<ReactTextInputMimeEvent> {

  public static final String EVENT_NAME = "mimeInput";

  private String mUri;
  private String mLinkUri;
  private String mData;
  private String mMime;

  public ReactTextInputMimeEvent(
    int viewId,
    String uri,
    String linkUri,
    String data,
    String mime) {
    super(viewId);
    mUri = uri;
    mLinkUri = linkUri;
    mData = data;
    mMime = mime;
  }

  @Override
  public String getEventName() {
    return EVENT_NAME;
  }

  @Override
  public void dispatch(RCTEventEmitter rctEventEmitter) {
    rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }

  private WritableMap serializeEventData() {
    WritableMap eventData = Arguments.createMap();
    eventData.putString("uri", mUri);
    eventData.putString("linkUri", mLinkUri);
    eventData.putString("data", mData);
    eventData.putString("mime", mMime);
    eventData.putInt("target", getViewTag());
    return eventData;
  }
}
