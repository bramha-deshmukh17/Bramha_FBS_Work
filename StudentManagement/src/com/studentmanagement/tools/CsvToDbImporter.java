package com.studentmanagement.tools;

import com.studentmanagement.model.MockStatus;
import com.studentmanagement.model.Student;
import com.studentmanagement.model.StudentDao;
import com.studentmanagement.model.StudentDaoJDBC;

import java.io.BufferedReader;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public final class CsvToDbImporter {

    CsvToDbImporter() {
    }

    public static final class ImportResult {
        public int insertedOrUpdated;
        public int failed;
        public String message;
    }

    public static ImportResult importStudentsCsvToDb(Path csvPath) {
        ImportResult r = new ImportResult();

        if (!isCsvFile(csvPath)) {
            r.failed = 1;
            r.message = "Please select a .csv file (not " + csvPath.getFileName()
                    + "). If you have .xlsx, export it as CSV.";
            return r;
        }

        StudentDao dao = new StudentDaoJDBC();

        try (BufferedReader br = Files.newBufferedReader(csvPath, StandardCharsets.UTF_8)) {
            String headerLine = br.readLine(); // consumes header row
            if (headerLine == null) {
                r.message = "CSV is empty: " + csvPath;
                return r;
            }

            int lineNo = 1;
            String line;
            while ((line = br.readLine()) != null) {
                lineNo++;
                if (line.trim().isEmpty())
                    continue;

                try {
                    // CSV order (matches your file): frn,email,mobile_no,name,git_repo,dob
                    String[] cols = line.split(",", -1);

                    String frn = (cols.length > 0) ? cols[0].trim() : null;
                    String email = (cols.length > 1) ? cols[1].trim() : null;
                    String mobileStr = (cols.length > 2) ? cols[2].trim() : null;
                    String name = (cols.length > 3) ? cols[3].trim() : null;
                    String gitRepo = (cols.length > 4) ? cols[4].trim() : null;
                    String dobStr = (cols.length > 5) ? cols[5].trim() : null;

                    if (frn == null || frn.isBlank()) {
                        throw new IllegalArgumentException("Missing FRN");
                    }

                    long mobile = (mobileStr == null || mobileStr.isBlank())
                            ? 0L
                            : Long.parseLong(mobileStr);

                    LocalDate dob = parseDate(dobStr);

                    Student s = new Student(frn.trim(), email, mobile, name, gitRepo, dob);
                    dao.addStudent(s);

                    r.insertedOrUpdated++;
                } catch (Exception ex) {
                    r.failed++;
                    System.out.println("Student CSV import failed at line " + lineNo + ": " + ex.getMessage());
                }
            }

            r.message = "Students import done. Upserted=" + r.insertedOrUpdated + ", Failed=" + r.failed;
            return r;

        } catch (MalformedInputException e) {
            r.failed = 1;
            r.message = "File encoding not supported. Save the CSV as UTF-8 and retry.";
            return r;
        } catch (Exception e) {
            r.failed++;
            r.message = "Students import crashed: " + e.getMessage();
            e.printStackTrace();
            return r;
        }
    }

    private static LocalDate parseDate(String dateStr) {
        if (dateStr == null || dateStr.isBlank())
            return null;

        String s = dateStr.trim();
        try {
            return LocalDate.parse(s, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException ignored) {
            // optional: keep silent; caller prints line number already
        }

        // FIX: close the quote
        throw new IllegalArgumentException("Invalid Date format: '" + dateStr + "'");
    }

    public static ImportResult importMocksCsvToDb(Path csvPath) {
        ImportResult r = new ImportResult();

        if (!isCsvFile(csvPath)) {
            r.failed = 1;
            r.message = "Please select a .csv file (not " + csvPath.getFileName()
                    + "). If you have .xlsx, export it as CSV.";
            return r;
        }

        StudentDao dao = new StudentDaoJDBC();

        try (BufferedReader br = Files.newBufferedReader(csvPath, StandardCharsets.UTF_8)) {
            String headerLine = br.readLine();
            if (headerLine == null) {
                r.message = "CSV is empty: " + csvPath;
                return r;
            }

            int lineNo = 1;

            String line;
            while ((line = br.readLine()) != null) {
                lineNo++;
                if (line.trim().isEmpty())
                    continue;

                try {
                    String[] cols = line.split(",", -1);

                    String frn = (cols.length > 0) ? cols[0].trim() : null;
                    String moduleName = (cols.length > 1) ? cols[1].trim() : null;
                    String statusStr = (cols.length > 2) ? cols[2].trim() : null;
                    String mockDate = (cols.length > 3) ? cols[3].trim() : null;

                    if (frn == null || frn.isBlank())
                        throw new IllegalArgumentException("Missing FRN");
                    if (moduleName == null || moduleName.isBlank())
                        throw new IllegalArgumentException("Missing moduleName");
                    if (statusStr == null || statusStr.isBlank())
                        throw new IllegalArgumentException("Missing status");

                    MockStatus.valueOf(statusStr.trim().toUpperCase());

                    System.out.println(dao.addOrUpdateMockDetail(
                            frn.trim(),
                            moduleName.trim(),
                            statusStr.trim().toUpperCase(),
                            parseDate(mockDate)));

                    r.insertedOrUpdated++;
                } catch (Exception ex) {
                    r.failed++;
                    System.out.println("Mock CSV import failed at line " + lineNo + ": " + ex.getMessage());
                }
            }

            r.message = "Mocks import done. Upserted=" + r.insertedOrUpdated + ", Failed=" + r.failed;
            return r;

        } catch (MalformedInputException e) {
            r.failed = 1;
            r.message = "File encoding not supported. Save the CSV as UTF-8 and retry.";
            return r;
        } catch (Exception e) {
            r.failed++;
            r.message = "Mocks import crashed: " + e.getMessage();
            return r;
        }
    }

    private static boolean isCsvFile(Path path) {
        String fileName = path.getFileName().toString().toLowerCase(Locale.ROOT);
        return fileName.endsWith(".csv");
    }
}