package web.demo.ui.demoui.dtos;

import org.springframework.web.multipart.MultipartFile;

public class ImageDTO extends InmuebleDTO {
	
	private MultipartFile image;
	
	private String path;
	
	public ImageDTO() {
		super();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
}
