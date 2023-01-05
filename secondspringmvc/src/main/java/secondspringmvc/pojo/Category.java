package secondspringmvc.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


	@Entity
	@Table(name = "category_0018")
	@NamedQueries({ @NamedQuery(name = "allCategories", query = "from Category") })
	public class Category {
		@Id
		@GeneratedValue(generator = "increment")
		@Column(name = "categoryName")
		String categoryName;
		@Column(name = "categoryDescription")
		String categoryDescription;
		@Column(name = "categoryImageUrl")
		String categoryImageUrl;

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		public String getCategoryDescription() {
			return categoryDescription;
		}

		public void setCategoryDescription(String categoryDescription) {
			this.categoryDescription = categoryDescription;
		}

		public String getCategoryImageUrl() {
			return categoryImageUrl;
		}

		public void setCategoryImageUrl(String categoryImageUrl) {
			this.categoryImageUrl = categoryImageUrl;
		}

	}


