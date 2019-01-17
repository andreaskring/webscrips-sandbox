package dk.magenta.sandbox.demoamp;

import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.NodeService;
import org.alfresco.service.namespace.QName;
import org.springframework.extensions.webscripts.AbstractWebScript;
import org.springframework.extensions.webscripts.WebScriptRequest;
import org.springframework.extensions.webscripts.WebScriptResponse;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

public class HurraWebscript extends AbstractWebScript {

    private NodeService nodeService;

    @Override
    public void execute(WebScriptRequest req, WebScriptResponse res) throws IOException {

        NodeRef siteNode = new NodeRef("workspace", "SpacesStore", "44f17e52-b7ac-4030-8539-b3c2668ca985");
        Map<QName, Serializable> properties = nodeService.getProperties(siteNode);

        res.getWriter().write("{\"message\":\"Dette er en test\"}");
    }

    public void setNodeService(NodeService nodeService) {
        this.nodeService = nodeService;
    }
}
