public interface CertificateTemplateRepository
        extends JpaRepository<CertificateTemplate, Long> {
    CertificateTemplate findByTemplateName(String templateName);
}