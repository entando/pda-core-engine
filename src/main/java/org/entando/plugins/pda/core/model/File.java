package org.entando.plugins.pda.core.model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Base64;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class File {
    private String type;
    private String name;
    private String data;
    private Integer size = 0;


    public File(String rawData) {
        String[] split = rawData.split(";");

        for (String property : split) {
            if (property.startsWith("data:")) {
                type = property.replace("data:", "");
            } else if (property.startsWith("name=")) {
                name = property.replace("name=", "").replace("%20", " ");
            } else if (property.startsWith("base64,")) {
                data = property.replace("base64,", "");
                size = Base64.getDecoder().decode(data).length;
            }
        }
    }

    public byte[] getDataAsByteArray() {
        return Base64.getDecoder().decode(data);
    }

    public void setData(byte[] data) {
        this.data = Base64.getEncoder().encodeToString(data);
        this.size = data.length;
    }

    public void setData(String data) {
        this.data = data;
        this.size = Base64.getDecoder().decode(data).length;
    }
}
