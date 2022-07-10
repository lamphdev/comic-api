package lamph11.web.comic.dto.request;

import lombok.Data;
import tech.jhipster.service.filter.InstantFilter;
import tech.jhipster.service.filter.StringFilter;

@Data
public class GetPostRequest extends PageRequest{

    StringFilter search;
    StringFilter status;
    InstantFilter createdDate;
    InstantFilter updatedDate;

}
