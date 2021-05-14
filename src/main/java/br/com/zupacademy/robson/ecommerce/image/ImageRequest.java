package br.com.zupacademy.robson.ecommerce.image;

import java.util.List;
import java.util.ArrayList;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class ImageRequest {

    @Size(min = 1)
    @NotNull
    private List<MultipartFile> images = new ArrayList();

    public void setImagens(List<MultipartFile> images) {
        this.images = images;
    }

    public List<MultipartFile> getImages() {
        return images;
    }
}
