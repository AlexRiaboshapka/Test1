package api.pojo.collections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyUrl {
    private String raw;
    private String protocol;
    private List<String> host;
    private List<String> path;
}
