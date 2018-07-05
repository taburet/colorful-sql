package prjx;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SqlFileType extends LanguageFileType {

    public static final SqlFileType INSTANCE = new SqlFileType();

    private SqlFileType() {
        super(SqlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "hzsql";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "hzsql";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "hzsql";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return null;
    }
}
