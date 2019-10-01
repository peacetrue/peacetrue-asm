package com.github.peacetrue.asm;

import org.junit.Test;

/**
 * @author xiayx
 */
public class RemoteFileTemplateUtilsTest {
    @Test
    public void change() throws Exception {
        RemoteFileTemplateUtils.makeStreamHolderPublic();
        byte[] bytes = RemoteFileTemplateUtils.changePayloadToInputStream();
        AsmUtils.write("com.github.peacetrue.asm.Generated", bytes);
        AsmUtils.printContent(bytes);
    }
}
