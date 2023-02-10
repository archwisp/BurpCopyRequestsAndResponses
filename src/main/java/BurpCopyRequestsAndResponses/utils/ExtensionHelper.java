/*
 * Copyright 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package BurpCopyRequestsAndResponses.utils;

import burp.IBurpExtenderCallbacks;
import burp.IHttpRequestResponse;
import burp.IContextMenuInvocation;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class ExtensionHelper {

  private IBurpExtenderCallbacks burpExtenderCallbacks;

  public ExtensionHelper(IBurpExtenderCallbacks burpExtenderCallbacks) {
    this.burpExtenderCallbacks = burpExtenderCallbacks;
  }
  
  public void copyRequests(IContextMenuInvocation contextMenuInvocation, Clipboard systemClipboard, ClipboardOwner owner) {
    StringBuilder stringBuilder = new StringBuilder();
    for (IHttpRequestResponse selectedMessage: contextMenuInvocation.getSelectedMessages()) {
      if (selectedMessage.getRequest() != null) {
        stringBuilder.append("#### ").append(new String(selectedMessage.getRequest()).split("\r\n", 2)[0]).append(System.lineSeparator());
        stringBuilder.append("```").append(System.lineSeparator());
        stringBuilder.append(new String(selectedMessage.getRequest())).append(System.lineSeparator());
        stringBuilder.append("```").append(System.lineSeparator());
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("#### ").append(new String(selectedMessage.getResponse()).split("\r\n", 2)[0]).append(System.lineSeparator());
        stringBuilder.append("```").append(System.lineSeparator());
        stringBuilder.append(new String(selectedMessage.getResponse())).append(System.lineSeparator());
        stringBuilder.append("```").append(System.lineSeparator());
        stringBuilder.append(System.lineSeparator());
      } else {
        this.burpExtenderCallbacks.issueAlert("The selected request is null.");
      }
    }

    systemClipboard.setContents(new StringSelection(stringBuilder.toString()), owner);
  }
}
