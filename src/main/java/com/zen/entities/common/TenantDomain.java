package com.zen.entities.common;

import jakarta.persistence.*;

@Entity
@Table(name = "tenant_domains", uniqueConstraints = @UniqueConstraint(columnNames = { "domain_name" }))
public class TenantDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tenant_id", nullable = false)
	private Tenant tenant;

	@Column(name = "domain_name", nullable = false, unique = true)
	private String domainName; // e.g. zen.com, mycorp.org

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
}
