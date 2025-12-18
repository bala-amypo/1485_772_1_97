public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    Certificate findByVerificationCode(String verificationCode);
}