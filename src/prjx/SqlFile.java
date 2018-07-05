package prjx;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class SqlFile extends PsiFileBase {

    protected SqlFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, SqlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return SqlFileType.INSTANCE;
    }

}
