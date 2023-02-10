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

package burp;
import BurpCopyRequestsAndResponses.utils.ExtensionHelper;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class ContextMenuFactory implements IContextMenuFactory, ClipboardOwner {
  private IBurpExtenderCallbacks burpExtenderCallbacks;
  private Clipboard systemClipboard;
  private ExtensionHelper extensionHelper;

  ContextMenuFactory(IBurpExtenderCallbacks burpExtenderCallbacks, ExtensionHelper extensionHelper, Clipboard systemClipboard) {
    this.burpExtenderCallbacks = burpExtenderCallbacks;
    this.extensionHelper = extensionHelper;
    this.systemClipboard = systemClipboard;
  }

  @Override
  public List<JMenuItem> createMenuItems(IContextMenuInvocation contextMenuInvocation) {
    List<JMenuItem> jMenuItems = new ArrayList<>();
    JMenuItem copyRequests = new JMenuItem("Copy request(s) and reponse(s)");
    copyRequests.addActionListener(e -> this.extensionHelper.copyRequests(contextMenuInvocation, systemClipboard, this));
    jMenuItems.add(copyRequests);
    return jMenuItems;
  }

  @Override
  public void lostOwnership(Clipboard clipboard, Transferable contents) {
  }
}
